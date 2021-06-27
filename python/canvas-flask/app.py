# $env:FLASK_APP="app.py"
# $env:FLASK_ENV="development"
# flask run

from flask import (Flask, render_template, request)
import random

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def showword():
    word = "congratulations"
    question = ''.join(random.sample(word, len(word)))
    message = "What is this?"

    if request.method=='POST':
        if request.form['answer']==word:
            message = "Yes, it is!"
            question = word
        else:
            message = "Oh No! Try Again"
    return render_template(
        'canvas.html', question=question, message=message)

