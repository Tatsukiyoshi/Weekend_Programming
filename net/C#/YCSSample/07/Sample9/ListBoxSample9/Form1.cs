using System;
using System.Windows.Forms;

namespace ListBoxSample9
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void lbx_SelectedIndexChanged(object sender, EventArgs e)
        {
            ListBox tmp = (ListBox)sender;

            lb.Text = tmp.Text + "を選びました。";
        }
    }
}
