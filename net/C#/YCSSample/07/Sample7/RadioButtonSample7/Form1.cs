using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RadioButtonSample7
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void rb_Click(object sender, EventArgs e)
        {
            RadioButton tmp = (RadioButton)sender;
            lb.Text = tmp.Text + "を選びました。";
        }
    }
}
