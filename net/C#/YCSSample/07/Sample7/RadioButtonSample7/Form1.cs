using System;
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
