using System;
using System.Windows.Forms;

namespace ButtonSample5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bt_Click(object sender, EventArgs e)
        {
            lb.Text = "ご購入ありがとうございました。";
            bt.Enabled = false;
        }
    }
}
