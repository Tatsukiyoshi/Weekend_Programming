namespace Item2
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        private TreeView tv;

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
            this.ClientSize = new System.Drawing.Size(300, 450);
            this.Text = "サンプル";

            tv = new TreeView();
            tv.Dock = DockStyle.Fill;

            string curDir = Directory.GetCurrentDirectory();
            TreeNode rootNode = new TreeNode();
            rootNode.Text = curDir;

            tv.Nodes.Add(rootNode);

            addSubDir(curDir, rootNode);

            tv.Parent = this;
        }

        private void addSubDir(string curDir, TreeNode rootNode)
        {
            string[] subFiles = Directory.GetFiles(curDir);

            for(int i = 0; i < subFiles.Length; i++)
            {
                TreeNode subNode = new TreeNode();
                rootNode.Nodes.Add(subNode);
                subNode.Text = Path.GetFileName(subFiles[i]);
            }
        }

        #endregion
    }
}