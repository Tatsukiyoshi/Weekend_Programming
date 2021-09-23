using System;
using System.Windows.Forms;

namespace ModelessFormSample14
{
    public partial class SampleForm : Form
    {
        public SampleForm()
        {
            InitializeComponent();
        }

        private void bt_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
