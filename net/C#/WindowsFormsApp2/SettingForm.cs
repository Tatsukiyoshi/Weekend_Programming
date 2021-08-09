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
    public partial class SettingForm : Form
    {
        public SettingForm()
        {
            InitializeComponent();

            // サンプルテキストは、背景を黒、前景を白で表示
            SampleText.ForeColor = Color.White;
            SampleText.BackColor = Color.Black;

            // 選択肢を初期設定
            FullColorOn.Checked = true; // 作成可能
            SolidOnly.Checked = true;   // 純色のみ
        }

        // 色選択ダイアログのクローズ
        private void CloseButton_Click(object sender, EventArgs e)
        {
            Program.PrintInfoLog("Clicked Close Button on SettingForm");
            this.Hide();
        }

        // 色選択開始
        private void ColorSelectButton_Click(object sender, EventArgs e)
        {
            // 色選択用ダイアログ
            ColorDialog ColorDialog1 = new ColorDialog();

            // 色選択の初期値は、サンプルテキストの表示色
            ColorDialog1.Color = SampleText.ForeColor;

            // 色選択で固定値を配置する（白、黒、赤、黄色、水色）
            ColorDialog1.CustomColors = new int[] {Color.White.ToArgb(), Color.Black.ToArgb(),
                Color.Red.ToArgb(), Color.Yellow.ToArgb(), Color.LightBlue.ToArgb()};

            // 色選択範囲
            ColorDialog1.SolidColorOnly = this.SolidOnly.Checked;

            // 色の作成可否の設定
            ColorDialog1.AllowFullOpen = this.FullColorOn.Checked;
            Program.PrintInfoLog("AllowFullOpen:" + ColorDialog1.AllowFullOpen.ToString());

            //　色を選択すると、サンプルテキストに反映
            if (ColorDialog1.ShowDialog() == DialogResult.OK)
            {
                Color SelectedColor = ColorDialog1.Color;
                SampleText.ForeColor = SelectedColor;
                Program.PrintInfoLog("Selected:" + SelectedColor.Name + "(" +
                        SelectedColor.R + "," + SelectedColor.G + "," + SelectedColor.B + ")");
            }
        }
    }
}
