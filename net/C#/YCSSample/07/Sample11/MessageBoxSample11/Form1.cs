using System;
using System.Windows.Forms;

namespace MessageBoxSample11
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bt_Click(object sender, EventArgs e)
        {
            MessageBox.Show("ご購入ありがとうございました。", "購入");
        }
    }
}
