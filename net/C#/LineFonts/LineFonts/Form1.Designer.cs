﻿namespace LineFonts
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
            RegularLabel = new Label();
            BoldLabel = new Label();
            SuspendLayout();
            // 
            // RegularLabel
            // 
            RegularLabel.AutoSize = true;
            RegularLabel.Location = new Point(31, 30);
            RegularLabel.Name = "RegularLabel";
            RegularLabel.Size = new Size(118, 25);
            RegularLabel.TabIndex = 0;
            RegularLabel.Text = "Regular Label";
            // 
            // BoldLabel
            // 
            BoldLabel.AutoSize = true;
            BoldLabel.Location = new Point(35, 96);
            BoldLabel.Name = "BoldLabel";
            BoldLabel.Size = new Size(94, 25);
            BoldLabel.TabIndex = 1;
            BoldLabel.Text = "Bold Label";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(BoldLabel);
            Controls.Add(RegularLabel);
            MaximizeBox = false;
            MinimizeBox = false;
            Name = "Form1";
            Text = "LINE Seed JP";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label RegularLabel;
        private Label BoldLabel;
    }
}