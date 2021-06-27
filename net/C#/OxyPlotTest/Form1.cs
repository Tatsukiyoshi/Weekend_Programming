using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using OxyPlot;
using OxyPlot.Axes;
using OxyPlot.Series;

namespace OxyPlotTest
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            var model = new PlotModel
            {
                Title = "Test ColumnSeries",
                Background = OxyColors.White
            };
            var axisX = new CategoryAxis { Position = AxisPosition.Bottom, Angle = -90 };
            model.Axes.Add(axisX);
            model.Axes.Add(new LinearAxis { Position = AxisPosition.Left, Minimum = 0.0, Maximum = 1.0 });
            plotView1.Model = model;

            List<string> texts = new List<string> { "hogehoge", "fuga", "foo bar" };
            Random r = new System.Random();

            //var series = new ColumnSeries { FillColor = OxyColors.DarkBlue }; // 棒グラフ
            var series = new LineSeries { Color = OxyColors.DarkBlue };         // 折れ線グラフ

            for (var i = 0; i < 50; i++)
            {
                //series.Items.Add(new ColumnItem(r.Next(80) / 100.0));
                series.Points.Add(new DataPoint(i, r.Next(80) / 100.0));
                axisX.Labels.Add(String.Format("{0} - {1}", texts[i % texts.Count], i));
            }
            model.Series.Add(series);

        }

        private void plotView1_Click(object sender, EventArgs e)
        {
            Console.WriteLine("clicked!");
            Random r = new System.Random();

            var series = new LineSeries { Color = OxyColors.DarkBlue };
            for (var i = 0; i < 50; i++)
            {
                series.Points.Add(new DataPoint(i, r.Next(80) / 100.0));
            }
            plotView1.Model.Series.Clear();  // データを直接置きかえる方法が分からないので
            plotView1.Model.Series.Add(series);
            plotView1.Model.InvalidatePlot(true);
        }
    }
}
