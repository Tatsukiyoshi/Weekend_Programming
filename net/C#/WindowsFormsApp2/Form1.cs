using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        // 色選択メニューの選択
        private void TextColor_Click(object sender, EventArgs e)
        {
            NLogService.PrintInfoLog("TextColor Clicked!");

            Form2 form2 = new Form2();
            form2.ShowDialog();
        }
    }
}
