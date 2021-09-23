using System;
using System.Windows.Forms;

namespace CheckboxSample6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void cb_CheckedChanged(object sender, EventArgs e)
        {
            CheckBox tmp = (CheckBox)sender;

            if (tmp.Checked == true)
            {
                lb.Text = tmp.Text + "を選びました。";
            }
            else if (tmp.Checked == false)
            {
                lb.Text = tmp.Text + "をやめました。";
            }
        }
    }
}
