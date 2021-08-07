
namespace WindowsFormsApp2
{
    partial class Form2
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
            this.fullColorOn = new System.Windows.Forms.RadioButton();
            this.fullColor = new System.Windows.Forms.GroupBox();
            this.fullColorOff = new System.Windows.Forms.RadioButton();
            this.sampleText = new System.Windows.Forms.Label();
            this.colorSelectButton = new System.Windows.Forms.Button();
            this.form2CloseButton = new System.Windows.Forms.Button();
            this.fullColor.SuspendLayout();
            this.SuspendLayout();
            // 
            // fullColorOn
            // 
            this.fullColorOn.AutoSize = true;
            this.fullColorOn.Location = new System.Drawing.Point(6, 18);
            this.fullColorOn.Name = "fullColorOn";
            this.fullColorOn.Size = new System.Drawing.Size(41, 16);
            this.fullColorOn.TabIndex = 0;
            this.fullColorOn.TabStop = true;
            this.fullColorOn.Text = "あり";
            this.fullColorOn.UseVisualStyleBackColor = true;
            // 
            // fullColor
            // 
            this.fullColor.Controls.Add(this.fullColorOff);
            this.fullColor.Controls.Add(this.fullColorOn);
            this.fullColor.Location = new System.Drawing.Point(21, 46);
            this.fullColor.Name = "fullColor";
            this.fullColor.Size = new System.Drawing.Size(117, 71);
            this.fullColor.TabIndex = 1;
            this.fullColor.TabStop = false;
            this.fullColor.Text = "色の作成";
            // 
            // fullColorOff
            // 
            this.fullColorOff.AutoSize = true;
            this.fullColorOff.Location = new System.Drawing.Point(7, 41);
            this.fullColorOff.Name = "fullColorOff";
            this.fullColorOff.Size = new System.Drawing.Size(42, 16);
            this.fullColorOff.TabIndex = 1;
            this.fullColorOff.TabStop = true;
            this.fullColorOff.Text = "なし";
            this.fullColorOff.UseVisualStyleBackColor = true;
            // 
            // sampleText
            // 
            this.sampleText.AutoSize = true;
            this.sampleText.Location = new System.Drawing.Point(19, 13);
            this.sampleText.Name = "sampleText";
            this.sampleText.Size = new System.Drawing.Size(43, 12);
            this.sampleText.TabIndex = 2;
            this.sampleText.Text = "サンプル";
            // 
            // colorSelectButton
            // 
            this.colorSelectButton.Location = new System.Drawing.Point(78, 8);
            this.colorSelectButton.Name = "colorSelectButton";
            this.colorSelectButton.Size = new System.Drawing.Size(75, 23);
            this.colorSelectButton.TabIndex = 3;
            this.colorSelectButton.Text = "選択";
            this.colorSelectButton.UseVisualStyleBackColor = true;
            this.colorSelectButton.Click += new System.EventHandler(this.button1_Click);
            // 
            // form2CloseButton
            // 
            this.form2CloseButton.Location = new System.Drawing.Point(63, 125);
            this.form2CloseButton.Name = "form2CloseButton";
            this.form2CloseButton.Size = new System.Drawing.Size(75, 23);
            this.form2CloseButton.TabIndex = 4;
            this.form2CloseButton.Text = "OK";
            this.form2CloseButton.UseVisualStyleBackColor = true;
            this.form2CloseButton.Click += new System.EventHandler(this.form2CloseButton_Click);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(191, 160);
            this.ControlBox = false;
            this.Controls.Add(this.form2CloseButton);
            this.Controls.Add(this.colorSelectButton);
            this.Controls.Add(this.sampleText);
            this.Controls.Add(this.fullColor);
            this.Name = "Form2";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "表示色選択";
            this.fullColor.ResumeLayout(false);
            this.fullColor.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton fullColorOn;
        private System.Windows.Forms.GroupBox fullColor;
        private System.Windows.Forms.RadioButton fullColorOff;
        private System.Windows.Forms.Label sampleText;
        private System.Windows.Forms.Button colorSelectButton;
        private System.Windows.Forms.Button form2CloseButton;
    }
}