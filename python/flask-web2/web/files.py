from flask import current_app
import os
import csv

def save_img(file):
    file.save(os.path.join(current_app.config['UPLOAD_FOLDER'], 'img', file.filename))

def save_csv(file):
    file.save(os.path.join(current_app.config['UPLOAD_FOLDER'], 'csv', file.filename))

def read_csv(filename):
    datalist = []
    with open(os.path.join(current_app.config['UPLOAD_FOLDER'], 'csv',
        filename), encoding="utf-8") as datafile: #文字コードを指定
        datareader = csv.reader(datafile)
        for row in datareader:
            datadict = {}
            datadict['name'] = row[0]
            datadict['bio'] = row[1]
            datalist.append(datadict)
        return datalist

def write_file(filename, str): #ファイル名と、書き込む文字列を引数に取る
    with open(os.path.join(current_app.config['UPLOAD_FOLDER'], 'csv',
        filename), 'w') as datafile: #ファイルの内容は全部上書きされる
        datafile.write(str)
        