import React from 'react'
import "./AvailableWindow.css"
import * as data from '../../../data/data.json'
import { SubjectRender } from '../SubjectRender/SubjectRender'

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


        // console.log(subjects)

        // subjects.sort(function (a: any, b: any) {
        //     var keyA = a.name;
        //     var keyB = b.name;
        //     var result = 0;
        //     // Compare the 2 dates
        //     if (keyA < keyB) result = -1;
        //     if (keyA > keyB) result = 1;
        //     console.log(keyA + " vs. " + keyB);
        //     console.log(result);
        //     return result;
        //     return 0;
        // })

        // console.log(subjects)

        return (
            <div className="availableWindow">
                <ul>{subjects}</ul>
            </div>
        );
    }
}
