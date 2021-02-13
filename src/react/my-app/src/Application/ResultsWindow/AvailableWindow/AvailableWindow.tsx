import React from 'react'
import "./AvailableWindow.css"
import * as data from '../../../data/data.json'
import { SubjectRender } from './SubjectRender/SubjectRender'

export class AvailableWindow extends React.Component {

    render(): JSX.Element {
        const available = data.data.available;

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
