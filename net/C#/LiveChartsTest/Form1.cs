using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

// 以下の namespace を追加
using LiveCharts;
using LiveCharts.Wpf;  // .Wpf は必要 / .WinForms は必要に応じて

namespace LiveChartsTest
{
    public partial class Form1 : Form
    {
        // Form1クラスのプロパティとして以下を追加
        public ChartValues<double> DataValues { get; set; }
        public List<string> Labels { get; set; }

        public Form1()
        {
            InitializeComponent();

            // コンストラクタのInitializeComponent()の後かForm1_Load内にて
            Labels = new List<string>();
            // (*1)
            cartesianChart1.AxisX.Add(new Axis
            {
                Labels = Labels,  // Labelsプロパティと紐づける
                Separator = new Separator { Step = 1, IsEnabled = false },
                LabelsRotation = -90
            });
            cartesianChart1.AxisY.Add(new Axis { MinValue = 0.0, MaxValue = 1.0 });
            cartesianChart1.BackColor = Color.White;
            // cartesianChart1.DisableAnimations = true;  // アニメーションを切るならtrue

            List<string> texts = new List<string> { "hogehoge", "fuga", "foo bar" };
            Random r = new System.Random();

            var valarray = new double[50];
            for (var i = 0; i < valarray.Length; i++)
            {
                valarray[i] = r.Next(80) / 100.0;
                Labels.Add(String.Format("{0} - {1}", texts[i % texts.Count], i));
            }
            DataValues = new ChartValues<double>(valarray);
            // (*2)
            cartesianChart1.Series.Add(new ColumnSeries
            {
                Values = DataValues,  // DataValuesプロパティと紐づける
                Fill = System.Windows.Media.Brushes.DarkBlue
            });
        }

        private void cartesianChart1_DataClick(object sender, ChartPoint chartPoint)
        {
            // イベントハンドラ cartesianChart1_DataClick にて
            Console.WriteLine("clicked!");
            Random r = new System.Random();
            var n = DataValues.Count;
            DataValues.Clear();
            DataValues.AddRange(new double[n].Select(_ => r.Next(80) / 100.0));

            for (var i = 0; i < cartesianChart1.Series[0].Values.Count; i++)
            {
                cartesianChart1.Series[0].Values[i] = r.Next(80) / 100.0;
            }
        }
    }
}
