using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TextBoxSample8
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Tb_KeyDown(object sender, KeyEventArgs e)
        {
            TextBox tmp = (TextBox)sender;
            if(e.KeyCode == Keys.Enter)
            {
                lb.Text = tmp.Text + "を選びました。";
            }
        }
    }
}
