namespace UnicodeFolder
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

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
            this.SelectFolderButton = new System.Windows.Forms.Button();
            this.FolderTextBox = new System.Windows.Forms.TextBox();
            this.ViewFolderButton = new System.Windows.Forms.Button();
            this.FileListBox = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // SelectFolderButton
            // 
            this.SelectFolderButton.Location = new System.Drawing.Point(19, 24);
            this.SelectFolderButton.Name = "SelectFolderButton";
            this.SelectFolderButton.Size = new System.Drawing.Size(112, 34);
            this.SelectFolderButton.TabIndex = 0;
            this.SelectFolderButton.Text = "選択";
            this.SelectFolderButton.UseVisualStyleBackColor = true;
            this.SelectFolderButton.Click += new System.EventHandler(this.SelectFolderButton_Click);
            // 
            // FolderTextBox
            // 
            this.FolderTextBox.Enabled = false;
            this.FolderTextBox.Location = new System.Drawing.Point(141, 26);
            this.FolderTextBox.Name = "FolderTextBox";
            this.FolderTextBox.Size = new System.Drawing.Size(499, 31);
            this.FolderTextBox.TabIndex = 1;
            // 
            // ViewFolderButton
            // 
            this.ViewFolderButton.Enabled = false;
            this.ViewFolderButton.Location = new System.Drawing.Point(648, 27);
            this.ViewFolderButton.Name = "ViewFolderButton";
            this.ViewFolderButton.Size = new System.Drawing.Size(112, 34);
            this.ViewFolderButton.TabIndex = 2;
            this.ViewFolderButton.Text = "表示";
            this.ViewFolderButton.UseVisualStyleBackColor = true;
            this.ViewFolderButton.Click += new System.EventHandler(this.ViewFolderButton_Click);
            // 
            // FileListBox
            // 
            this.FileListBox.FormattingEnabled = true;
            this.FileListBox.ItemHeight = 25;
            this.FileListBox.Location = new System.Drawing.Point(18, 69);
            this.FileListBox.Name = "FileListBox";
            this.FileListBox.Size = new System.Drawing.Size(742, 329);
            this.FileListBox.TabIndex = 3;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(772, 450);
            this.Controls.Add(this.FileListBox);
            this.Controls.Add(this.ViewFolderButton);
            this.Controls.Add(this.FolderTextBox);
            this.Controls.Add(this.SelectFolderButton);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.Text = "フォルダ表示";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button SelectFolderButton;
        private TextBox FolderTextBox;
        private Button ViewFolderButton;
        private ListBox FileListBox;
    }
}