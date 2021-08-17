
namespace WindowsFormsApp2
{
    partial class SettingForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.FullColorOn = new System.Windows.Forms.RadioButton();
            this.FullColor = new System.Windows.Forms.GroupBox();
            this.FullColorOff = new System.Windows.Forms.RadioButton();
            this.SampleText = new System.Windows.Forms.Label();
            this.ColorSelectButton = new System.Windows.Forms.Button();
            this.CloseButton = new System.Windows.Forms.Button();
            this.FullColor.SuspendLayout();
            this.SuspendLayout();
            // 
            // FullColorOn
            // 
            this.FullColorOn.AutoSize = true;
            this.FullColorOn.Location = new System.Drawing.Point(6, 18);
            this.FullColorOn.Name = "FullColorOn";
            this.FullColorOn.Size = new System.Drawing.Size(41, 16);
            this.FullColorOn.TabIndex = 0;
            this.FullColorOn.TabStop = true;
            this.FullColorOn.Text = "あり";
            this.FullColorOn.UseVisualStyleBackColor = true;
            // 
            // FullColor
            // 
            this.FullColor.Controls.Add(this.FullColorOff);
            this.FullColor.Controls.Add(this.FullColorOn);
            this.FullColor.Location = new System.Drawing.Point(21, 46);
            this.FullColor.Name = "FullColor";
            this.FullColor.Size = new System.Drawing.Size(117, 71);
            this.FullColor.TabIndex = 1;
            this.FullColor.TabStop = false;
            this.FullColor.Text = "色の作成";
            // 
            // FullColorOff
            // 
            this.FullColorOff.AutoSize = true;
            this.FullColorOff.Location = new System.Drawing.Point(7, 41);
            this.FullColorOff.Name = "FullColorOff";
            this.FullColorOff.Size = new System.Drawing.Size(42, 16);
            this.FullColorOff.TabIndex = 1;
            this.FullColorOff.TabStop = true;
            this.FullColorOff.Text = "なし";
            this.FullColorOff.UseVisualStyleBackColor = true;
            // 
            // SampleText
            // 
            this.SampleText.AutoSize = true;
            this.SampleText.Location = new System.Drawing.Point(19, 13);
            this.SampleText.Name = "SampleText";
            this.SampleText.Size = new System.Drawing.Size(43, 12);
            this.SampleText.TabIndex = 2;
            this.SampleText.Text = "サンプル";
            // 
            // ColorSelectButton
            // 
            this.ColorSelectButton.Location = new System.Drawing.Point(78, 8);
            this.ColorSelectButton.Name = "ColorSelectButton";
            this.ColorSelectButton.Size = new System.Drawing.Size(75, 23);
            this.ColorSelectButton.TabIndex = 3;
            this.ColorSelectButton.Text = "選択";
            this.ColorSelectButton.UseVisualStyleBackColor = true;
            this.ColorSelectButton.Click += new System.EventHandler(this.button1_Click);
            // 
            // CloseButton
            // 
            this.CloseButton.Location = new System.Drawing.Point(63, 125);
            this.CloseButton.Name = "CloseButton";
            this.CloseButton.Size = new System.Drawing.Size(75, 23);
            this.CloseButton.TabIndex = 4;
            this.CloseButton.Text = "OK";
            this.CloseButton.UseVisualStyleBackColor = true;
            this.CloseButton.Click += new System.EventHandler(this.CloseButton_Click);
            // 
            // SettingForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(191, 160);
            this.ControlBox = false;
            this.Controls.Add(this.CloseButton);
            this.Controls.Add(this.ColorSelectButton);
            this.Controls.Add(this.SampleText);
            this.Controls.Add(this.FullColor);
            this.Name = "SettingForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "表示色選択";
            this.FullColor.ResumeLayout(false);
            this.FullColor.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton FullColorOn;
        private System.Windows.Forms.GroupBox FullColor;
        private System.Windows.Forms.RadioButton FullColorOff;
        private System.Windows.Forms.Label SampleText;
        private System.Windows.Forms.Button ColorSelectButton;
        private System.Windows.Forms.Button CloseButton;
    }
}