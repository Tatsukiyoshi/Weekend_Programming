namespace Normalization
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void InputTextBox_TextChanged(object sender, EventArgs e)
        {
            UnicodeGroupBox.Enabled = true;
            MethodGroupBox.Enabled = true;
        }

        private void UnicodeFormC_CheckedChanged(object sender, EventArgs e)
        {
            OutputLabel.Text = InputTextBox.Text.Normalize();
            InstanceMethod.Checked = true;
        }

        private void UnicodeFormD_CheckedChanged(object sender, EventArgs e)
        {
            OutputLabel.Text = InputTextBox.Text.Normalize(System.Text.NormalizationForm.FormD);
            InstanceMethod.Checked = true;
        }

        private void StaticMethod_CheckedChanged(object sender, EventArgs e)
        {
            if(UnicodeFormC.Checked)
            {
                OutputLabel.Text = StringNormalizationExtensions.Normalize(InputTextBox.Text);
            }
            else if(UnicodeFormD.Checked)
            {
                OutputLabel.Text = StringNormalizationExtensions.Normalize(InputTextBox.Text, System.Text.NormalizationForm.FormD);
            }
        }

        private void InstanceMethod_CheckedChanged(object sender, EventArgs e)
        {
            if (UnicodeFormC.Checked)
            {
                OutputLabel.Text = InputTextBox.Text.Normalize();
            }
            else if (UnicodeFormD.Checked)
            {
                OutputLabel.Text = InputTextBox.Text.Normalize(System.Text.NormalizationForm.FormD);
            }
        }
    }
}
