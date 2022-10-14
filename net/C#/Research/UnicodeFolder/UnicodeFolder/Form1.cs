namespace UnicodeFolder
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        /// <summary>
        /// フォルダ選択
        /// </summary>
        /// <param name="sender">送信元オブジェクト</param>
        /// <param name="e">イベントに関する引数</param>
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
        /// ファイル一覧表示
        /// </summary>
        /// <param name="sender">送信元オブジェクト</param>
        /// <param name="e">イベントに関する引数</param>
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
