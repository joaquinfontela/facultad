import React from 'react'
import "./SubjectCheckbox.css"

interface SubjectCheckboxProps {
    code: string,
    passed: boolean,
    failed: boolean,
    handlePassedClick: any,
    handleFailedClick: any
}

export default class SubjectCheckbox extends React.Component<SubjectCheckboxProps, {}> {

    render(): JSX.Element {
        return (
            <li className="subjectCheckboxContainer">
                <text>{this.props.code}</text>
                <input className="subjectPassedCheckbox"
                    type="checkbox"
                    checked={this.props.passed}
                    onChange={() => { this.props.handlePassedClick(this.props.code) }}></input>
                <input className="subjectFailedCheckbox"
                    type="checkbox"
                    checked={this.props.failed}
                    onChange={() => { this.props.handleFailedClick(this.props.code) }}></input>
            </li>
        );
    }
}