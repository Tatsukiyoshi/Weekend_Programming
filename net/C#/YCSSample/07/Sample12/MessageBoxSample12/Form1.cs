using System;
using System.Windows.Forms;

namespace MessageBoxSample12
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void bt_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("本当に購入しますか？", "確認",
                MessageBoxButtons.YesNo, MessageBoxIcon.Question);

            if (dr == DialogResult.Yes)
            {
                MessageBox.Show("ご購入ありがとうございました。", "購入",
                    MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }
    }
}
