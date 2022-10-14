namespace Normalization
{
    /// <summary>
    /// Unicode���K�`����
    /// </summary>
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        /// <summary>
        /// ���͂����ꍇ�A���W�I�{�^����I���ł���悤�ɂ���
        /// </summary>
        /// <param name="sender">���M���I�u�W�F�N�g</param>
        /// <param name="e">�C�x���g�Ɋւ������</param>
        private void InputTextBox_TextChanged(object sender, EventArgs e)
        {
            UnicodeGroupBox.Enabled = true;
            MethodGroupBox.Enabled = true;
        }

        /// <summary>
        /// ���K�`C��I������ƁA���K�`C�Ń��x���ɏo�͂���i�C���X�^���X���\�b�h�j
        /// </summary>
        /// <param name="sender">���M���I�u�W�F�N�g</param>
        /// <param name="e">�C�x���g�Ɋւ������</param>
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
        /// ���\�b�h�I���ɉ����āA�g�p���郁�\�b�h��؂�ւ���
        /// </summary>
        /// <param name="sender">���M���I�u�W�F�N�g</param>
        /// <param name="e">�C�x���g�Ɋւ������</param>
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
