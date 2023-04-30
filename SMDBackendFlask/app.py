from flask import Flask, render_template, request
import json
app = Flask(__name__)

@app.route('/')
def home():
    return 'Hello, World!'

@app.route('/getCategoriesAndPopulars')
def getCategoriesAndPopulars():
    with open('foodAppResponse.json', 'r') as file:
        data = json.load(file)
        return data

if __name__ == '__main__':
    app.run(debug=True)