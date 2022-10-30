namespace LineFonts
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
            this.RegularLabel = new System.Windows.Forms.Label();
            this.BoldLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // RegularLabel
            // 
            this.RegularLabel.AutoSize = true;
            this.RegularLabel.Location = new System.Drawing.Point(31, 30);
            this.RegularLabel.Name = "RegularLabel";
            this.RegularLabel.Size = new System.Drawing.Size(118, 25);
            this.RegularLabel.TabIndex = 0;
            this.RegularLabel.Text = "Regular Label";
            // 
            // BoldLabel
            // 
            this.BoldLabel.AutoSize = true;
            this.BoldLabel.Location = new System.Drawing.Point(35, 96);
            this.BoldLabel.Name = "BoldLabel";
            this.BoldLabel.Size = new System.Drawing.Size(94, 25);
            this.BoldLabel.TabIndex = 1;
            this.BoldLabel.Text = "Bold Label";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.BoldLabel);
            this.Controls.Add(this.RegularLabel);
            this.Name = "Form1";
            this.Text = "LINE Seed JP";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Label RegularLabel;
        private Label BoldLabel;
    }
}