
class Controller { 
    constructor() {
        this.audioBlob = null;
        this.timeout = null;
    }

    start() {
        const btnAudio = document.querySelector('.btn-audio');
        const formWrapper = document.querySelector('.form-wrapper');
        let view = new View(null);
        let model = new Model();
        formWrapper.addEventListener('click', (e) => {
            if(e.target.classList.contains('btn-audio') && e.target.innerText === 'Click here') {
                e.target.innerText = 'Speak';
                // view.animate();
                model.recognize();
            } else if(e.target.classList.contains('btn-audio') && e.target.innerText === 'Speak') {
                e.target.innerText = 'Click here';
                // view.exitAnimate();
            } else if(e.target.classList.contains('true')) {
                e.target.classList.add('btn-active');
                model.sendHttpRequest();
                // model.userData();
            } else if(e.target.classList.contains('false')) {
                e.target.classList.add('btn-active');
                model.sendHttpRequest();
                model.recognize();
            }

        });
    }
    
}

class Model {
    constructor() {

    }

    userData() {
        const string = document.querySelector('.user-data').innerText;
        const dataArray = string.split(' ');
        const btnActive = document.querySelector('.btn-active');

        const dataObj = {
            name: dataArray[0],
            surname: dataArray[1] ,
            status: btnActive.getAttribute('data-status')
        };
        btnActive.classList.remove('btn-active');
        return JSON.stringify(dataObj);
    }
    recognize() {
        let recognizer = new webkitSpeechRecognition();
        recognizer.interimResults = true;
        recognizer.lang = 'en-En';
        recognizer.onresult = (event) => {
            let result = event.results[event.resultIndex];
            if (result.isFinal) {
                let view = new View(result[0].transcript);
                view.render();
                this.talk();
            } 
        };
        recognizer.start();
    }

    sendHttpRequest() {
        const userData = this.userData();
        console.log(userData);
        const url = "DBSaveServlet";
        // let name = userData.name;
        // let surname = userData.surname;
        // const body = 'name=' + name + '&surname=' + surname;
        console.log('test');
        const request = new XMLHttpRequest();
        request.open("POST", url, true);
        request.setRequestHeader('Content-Type', 'application/json');
        request.onload = function(e) {
            if(this.status === 200 && this.readyState == 4) {
                console.log('it is working');
            } else {
                console.error('It isn`t working');
            }
        };

        request.send(userData);
    }
    talk() {
        const utterance = new SpeechSynthesisUtterance(document.querySelector('.user-data').innerText);
        window.speechSynthesis.speak(utterance);
    }
}

class View {
    constructor(data) {
        this.data = data;
        this.timeout = null;
    }

    render() {
        const fullName = document.querySelector('.user-data');
        const btnAudio = document.querySelector('.btn-audio');
        fullName.innerText = this.data;
        btnAudio.innerText = 'Click here';
        btnAudio.classList.remove('btn-active');
        // this.exitAnimate();
    }

    // animate() {
    //     const btnAudio = document.querySelector('.btn-audio');
    //     btnAudio.classList.toggle('btn-active');
    //     this.timeout = setInterval(this.animate, 500);
    // }

    // exitAnimate() {
    //     clearInterval(this.timeout);
    // }
}

const controller = new Controller();
controller.start();




