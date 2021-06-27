using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Sample4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        // キー入力したときに呼び出される
        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            String str;

            if(e.KeyCode == Keys.Up)
            {
                str = "上";
            } 
            else if(e.KeyCode == Keys.Down)
            {
                str = "下";
            } else if(e.KeyCode == Keys.Right)
            {
                str = "右";
            } else if(e.KeyCode == Keys.Left)
            {
                str = "左";
            } else
            {
                str = "他のキー";
            }

            label2.Text = str + "ですね。";
        }
    }
}
