using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PanelSample1
{
    public partial class Form1 : Form
    {
        private Button[] bt = new Button[6];
        private FlowLayoutPanel flp;

        public Form1()
        {
            InitializeComponent();

            this.Text = "サンプル";
            this.Width = 600; this.Height = 100;

            flp = new FlowLayoutPanel();
            flp.Dock = DockStyle.Fill;

            for(int i = 0; i < bt.Length; i++)
            {
                bt[i] = new Button();
                bt[i].Text = Convert.ToString(i);
                bt[i].Parent = flp;
            }

            flp.Parent = this;
        }
    }
}
