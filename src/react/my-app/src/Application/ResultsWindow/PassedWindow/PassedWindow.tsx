import React from 'react'
import "./PassedWindow.css"
import * as data from '../../../data/data.json'
import { SubjectRender } from '../SubjectRender/SubjectRender'

interface Subject {
    code: string,
    name: string,
    credits: number
}

export class PassedWindow extends React.Component {

    render(): JSX.Element {
        const passed: Subject[] = data.data.passed;

        passed.sort(function (a: Subject, b: Subject) {
            var keyA = a.code;
            var keyB = b.code;
            if (keyA < keyB) return -1;
            if (keyA > keyB) return 1;
            return 0;
        })

        const subjects = passed.map((s) => {
            return (
                <SubjectRender
                    code={s.code}
                    name={s.name}
                    credits={s.credits}
                />
            );
        })

        return (
            <div className="passedWindow">
                <ul>{subjects}</ul>
            </div>
        );
    }
}
