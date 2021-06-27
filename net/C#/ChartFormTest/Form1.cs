using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ChartFormTest
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            chart1.Titles.Add("Test Chart Control");
            chart1.ChartAreas[0].AxisX.LabelStyle.Angle = -90;
            chart1.ChartAreas[0].AxisX.Interval = 1;
            chart1.ChartAreas[0].AxisX.MajorGrid.Enabled = false;
            chart1.ChartAreas[0].AxisY.Maximum = 1.0;
            chart1.ChartAreas[0].AxisY.Minimum = 0.0;
            chart1.Series["Series1"].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            chart1.Series["Series1"].Color = Color.DarkBlue;

            List<string> texts = new List<string> { "hogehoge", "fuga", "foo bar" };
            Random r = new System.Random();
            for (var i = 0; i < 50; i++)
            {
                chart1.Series["Series1"].Points.AddXY(i, r.Next(80) / 100.0);
                chart1.Series["Series1"].Points[i].AxisLabel
                    = String.Format("{0} - {1}", texts[i % texts.Count], i);
            }
        }

        private void chart1_Click(object sender, EventArgs e)
        {
            // クリックイベントハンドラ (chart1_Click) にて
            Console.WriteLine("clicked!");
            Random r = new System.Random();
            foreach (var pointData in chart1.Series["Series1"].Points)
            {
                pointData.SetValueY(r.Next(80) / 100.0);
            }
            chart1.Refresh();  // これが必要
        }
    }
}
