using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Sample3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        
        // マウスカーソルが入ったときに呼び出される
        private void Form1_MouseEnter(object sender, EventArgs e)
        {
            this.label1.Text = "こんにちは";
        }

        // マウスカーソルが出たときに呼び出される
        private void Form1_MouseLeave(object sender, EventArgs e)
        {
            this.label1.Text = "さようなら";
        }
    }
}
