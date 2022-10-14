namespace Normalization
{
    /// <summary>
    /// Unicode正規形調査
    /// </summary>
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        /// <summary>
        /// 入力した場合、ラジオボタンを選択できるようにする
        /// </summary>
        /// <param name="sender">送信元オブジェクト</param>
        /// <param name="e">イベントに関する引数</param>
        private void InputTextBox_TextChanged(object sender, EventArgs e)
        {
            UnicodeGroupBox.Enabled = true;
            MethodGroupBox.Enabled = true;
        }

        /// <summary>
        /// 正規形Cを選択すると、正規形Cでラベルに出力する（インスタンスメソッド）
        /// </summary>
        /// <param name="sender">送信元オブジェクト</param>
        /// <param name="e">イベントに関する引数</param>
        private void Form_CheckedChanged(object sender, EventArgs e)
        {
            InstanceMethod.Checked = true;

            if (UnicodeFormC.Checked)
            {
                OutputLabel.Text = InputTextBox.Text.Normalize();
            }
            else if(UnicodeFormD.Checked)
            {
                OutputLabel.Text = InputTextBox.Text.Normalize(System.Text.NormalizationForm.FormD);
            }
        }

        /// <summary>
        /// メソッド選択に応じて、使用するメソッドを切り替える
        /// </summary>
        /// <param name="sender">送信元オブジェクト</param>
        /// <param name="e">イベントに関する引数</param>
        private void Method_CheckedChanged(object sender, EventArgs e)
        {
            if (UnicodeFormC.Checked)
            {
                if(StaticMethod.Checked)
                {
                    OutputLabel.Text = StringNormalizationExtensions.Normalize(InputTextBox.Text);
                } 
                else if (InstanceMethod.Checked)
                {
                    OutputLabel.Text = InputTextBox.Text.Normalize();
                }
            }
            else if (UnicodeFormD.Checked)
            {
                if (StaticMethod.Checked)
                {
                    OutputLabel.Text = StringNormalizationExtensions.Normalize(InputTextBox.Text, System.Text.NormalizationForm.FormD);
                }
                else if(InstanceMethod.Checked)
                {
                    OutputLabel.Text = InputTextBox.Text.Normalize(System.Text.NormalizationForm.FormD);
                }
            }
        }
    }
}
