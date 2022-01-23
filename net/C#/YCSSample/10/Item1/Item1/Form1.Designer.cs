namespace Item1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private ListBox lbx;
        private Button bt;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(300, 300);
            this.Text = "サンプル";

            // ファイル一覧リストボックス
            lbx = new ListBox();
            lbx.Dock = DockStyle.Top;

            // フォルダ選択ボタン
            bt = new Button();
            bt.Dock = DockStyle.Bottom;
            bt.Text = "選択";
            bt.Click += new EventHandler(bt_Click);

            lbx.Parent = this;
            bt.Parent = this;
        }
        
        private void bt_Click(object sender, EventArgs e)
        {
            // フォルダ選択ダイアログ
            FolderBrowserDialog fbd = new FolderBrowserDialog();

            // フォルダを選択した場合
            if(fbd.ShowDialog() == DialogResult.OK)
            {
                // ファイル一覧をクリア
                lbx.Items.Clear();
                
                string dir = fbd.SelectedPath;              // 選択したフォルダ
                string[] fstr = Directory.GetFiles(dir);    // 選択したフォルダ配下のファイル名

                // ファイル一覧更新
                for(int i = 0; i < fstr.Length; i++)
                {
                    lbx.Items.Add(fstr[i]);
                }
            }
        }

        #endregion
    }
}