using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PanelSample2
{
    public partial class Form1 : Form
    {
        private Button[] bt = new Button[6];
        private TableLayoutPanel tlp;

        public Form1()
        {
            InitializeComponent();

            this.Text = "サンプル";
            this.Width = 300; this.Height = 300;

            tlp = new TableLayoutPanel();
            tlp.Dock = DockStyle.Fill;
            tlp.ColumnCount = 3;
            tlp.RowCount = 2;

            for(int i = 0; i < bt.Length; i++)
            {
                bt[i] = new Button();
                bt[i].Text = Convert.ToString(i);
                bt[i].Parent = tlp;
            }

            tlp.Parent = this;
        }
    }
}
