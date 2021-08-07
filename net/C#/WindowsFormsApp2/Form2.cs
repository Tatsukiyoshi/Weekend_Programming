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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();

            sampleText.BackColor = Color.Black;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // 色選択用ダイアログ
            ColorDialog colorDialog1 = new ColorDialog();

            // 色選択の初期値は、サンプルテキストの表示色
            colorDialog1.Color = sampleText.ForeColor;

            // 色の作成可否の設定
            colorDialog1.AllowFullOpen = this.fullColorOn.Checked;

            //　色を選択すると、サンプルテキストに反映
            if(colorDialog1.ShowDialog() == DialogResult.OK)
            {
                sampleText.ForeColor = colorDialog1.Color;
            }
        }

        private void form2CloseButton_Click(object sender, EventArgs e)
        {
            this.Hide();
        }
    }
}
