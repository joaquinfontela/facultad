import React from 'react'
import "./RemainingWindow.css"
import * as data from '../../../data/data.json'
import { SubjectRender } from '../SubjectRender/SubjectRender'
import { SubjectCodeInput } from '../SubjectCodeInput/SubjectCodeInput'

interface RemainingWindowState {
    input: string;
}

interface Subject {
    code: string,
    name: string,
    credits: number
}

export class RemainingWindow extends React.Component<{}, RemainingWindowState> {

    constructor(props: any) {
        super(props);
        this.handleInputChange = this.handleInputChange.bind(this);
        this.state = {
            input: ""
        }
    }

    handleInputChange(newInput: string): void {
        if ((!isNaN(Number(newInput)) || (newInput === ".")) && (newInput.length <= 5)) {
            this.setState({
                input: newInput
            })
        }
    }

    render(): JSX.Element {
        const subjectsToDo = data.data.left;
        const subjectsLeft = (subjectsToDo as any)[this.state.input];

        if (!subjectsLeft) {
            return (
                <div className="remainingWindow">
                    <div className="remainingWindowTitle">Ingrese el codigo de la materia:</div>
                    <SubjectCodeInput input={this.state.input} handleChange={this.handleInputChange} />
                    <div className="subjectNotFoundErrorMessage">{(this.state.input === "") ? "" : "La materia ingresada no fue encontrada entre tus pendientes."}</div>
                </div>
            );
        }

        subjectsLeft.sort(function (a: any, b: any) {
            var keyA = a.code;
            var keyB = b.code;
            if (keyA < keyB) return -1;
            if (keyA > keyB) return 1;
            return 0;
        })

        const subjects = subjectsLeft.map((s: Subject) => {
            return (
                <SubjectRender
                    code={s.code}
                    name={s.name}
                    credits={s.credits}
                />
            );
        })

        return (
            <div className="remainingWindow" >
                <div className="remainingWindowTitle">Ingrese el codigo de la materia:</div>
                <SubjectCodeInput input={this.state.input} handleChange={this.handleInputChange} />
                <ul>{subjects}</ul>
            </div>
        );
    }
}
