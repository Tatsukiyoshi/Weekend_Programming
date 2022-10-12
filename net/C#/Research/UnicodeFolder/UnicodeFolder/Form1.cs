namespace UnicodeFolder
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        /// <summary>
        /// �t�H���_�I��
        /// </summary>
        /// <param name="sender">���M���I�u�W�F�N�g</param>
        /// <param name="e">�C�x���g�Ɋւ������</param>
        private void SelectFolderButton_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog dlg = new();

            if(dlg.ShowDialog() == DialogResult.OK)
            {
                string Path = dlg.SelectedPath;

                string unicodePath = Path.Normalize(System.Text.NormalizationForm.FormD);

                if (unicodePath.IsNormalized() == false)
                {
                    unicodePath = unicodePath.Normalize();
                }

                FolderTextBox.Text = unicodePath;
                ViewFolderButton.Enabled = true;
            }
        }

        /// <summary>
        /// �t�@�C���ꗗ�\��
        /// </summary>
        /// <param name="sender">���M���I�u�W�F�N�g</param>
        /// <param name="e">�C�x���g�Ɋւ������</param>
        private void ViewFolderButton_Click(object sender, EventArgs e)
        {
            string[] files = Directory.GetFiles(FolderTextBox.Text);

            foreach(string file in files)
            {
                FileListBox.Items.Add(file);
            }
        }
    }
}
