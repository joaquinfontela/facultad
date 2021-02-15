import React from 'react'
import "./AvailableWindow.css"
import * as data from '../../../data/data.json'
import { SubjectRender } from '../SubjectRender/SubjectRender'

interface Subject {
    code: string,
    name: string,
    credits: number
}

export class AvailableWindow extends React.Component {

    render(): JSX.Element {
        const available: Subject[] = data.data.available;

        available.sort(function (a: Subject, b: Subject) {
            var keyA = a.code;
            var keyB = b.code;
            if (keyA < keyB) return -1;
            if (keyA > keyB) return 1;
            return 0;
        })

        const subjects = available.map((s) => {
            return (
                <SubjectRender
                    code={s.code}
                    name={s.name}
                    credits={s.credits}
                />
            );
        })

        return (
            <div className="availableWindow">
                <ul>{subjects}</ul>
            </div>
        );
    }
}
