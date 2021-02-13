import React from 'react'
import "./CreditsWindow.css"
import * as data from '../../../data/data.json'

export class CreditsWindow extends React.Component {

    render(): JSX.Element {

        return (
            <div className="creditsWindow">
                A lo largo de tu carrera acumulaste {data.data.credits} créditos.
            </div>
        );
    }
}