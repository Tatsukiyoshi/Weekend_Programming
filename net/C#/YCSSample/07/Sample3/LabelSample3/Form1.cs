using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LabelSample3
{
    public partial class Form1 : Form
    {
        private Label[] lb = new Label[3];
        private TableLayoutPanel tlp;
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
                lb[i].Text = i + "号車です。";
            }

            // 前景色を設定しますto
            lb[0].ForeColor = Color.Black;
            lb[1].ForeColor = Color.Black;
            lb[2].ForeColor = Color.Black;

            // 背景色を設定します
            lb[0].BackColor = Color.White;
            lb[1].BackColor = Color.Gray;
            lb[2].BackColor = Color.White;

            // 位置揃えを設定します
            lb[0].TextAlign = ContentAlignment.TopLeft;
            lb[1].TextAlign = ContentAlignment.MiddleCenter;
            lb[2].TextAlign = ContentAlignment.BottomRight;

            // 境界線を設定します
            lb[0].BorderStyle = BorderStyle.None;
            lb[1].BorderStyle = BorderStyle.FixedSingle;
            lb[2].BorderStyle = BorderStyle.Fixed3D;

            //for(int i = 0; i < lb.Length; i++)
            //{
            //    lb[i].Parent = tlp;
            //}
            // foearchに変換
            foreach(Label v in lb)
            {
                v.Parent = tlp;
            }

            tlp.Parent = this;
        }
    }
}
