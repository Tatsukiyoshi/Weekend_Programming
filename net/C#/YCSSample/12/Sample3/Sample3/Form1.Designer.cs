﻿namespace Sample3
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
            this.lbx = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // lbx
            // 
            this.lbx.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lbx.FormattingEnabled = true;
            this.lbx.ItemHeight = 25;
            this.lbx.Location = new System.Drawing.Point(0, 0);
            this.lbx.Name = "lbx";
            this.lbx.Size = new System.Drawing.Size(278, 144);
            this.lbx.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(10F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(278, 144);
            this.Controls.Add(this.lbx);
            this.Name = "Form1";
            this.Text = "サンプル";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private ListBox lbx;
    }
}