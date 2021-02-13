import React from 'react'
import "./PassedWindow.css"
import * as data from '../../../data/data.json'
import { SubjectRender } from '../SubjectRender/SubjectRender'

export class PassedWindow extends React.Component {

    render(): JSX.Element {
        const passed = data.data.passed;

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
