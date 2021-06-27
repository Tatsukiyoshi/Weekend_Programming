using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

// Lesson６：練習問題２
namespace Item2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_MouseEnter(object sender, EventArgs e)
        {
            this.button1.Text = "こんにちは";
        }

        private void button1_MouseLeave(object sender, EventArgs e)
        {
            this.button1.Text = "さようなら";
        }
    }
}
