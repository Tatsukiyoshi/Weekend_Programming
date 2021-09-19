using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FontSample4
{
    public partial class Form1 : Form
    {
        // フィールドを読み取り専用にするとよい
        private readonly Label[] lb = new Label[3];
        private readonly TableLayoutPanel tlp;

        public Form1()
        {
            InitializeComponent();

            this.Text = "サンプル";
            this.Width = 250; this.Height = 200;

            tlp = new TableLayoutPanel();
            tlp.Dock = DockStyle.Fill;

            tlp.ColumnCount = 1;
            tlp.RowCount = 3;

            for(int i = 0; i < lb.Length; i++)
            {
                lb[i] = new Label();
                lb[i].Text = "This is a Car.";
                lb[i].Width = 200;
            }

            lb[0].Font = new Font("Arial", 12, FontStyle.Bold);
            lb[1].Font = new Font("Times New Roman", 14, FontStyle.Bold);
            lb[2].Font = new Font("Courier New", 16, FontStyle.Bold);

            foreach (Label v in lb)
            {
                v.Parent = tlp;
            }

            tlp.Parent = this;
        }
    }
}
