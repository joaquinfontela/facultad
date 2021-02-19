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
                <label className="passedContainer">
                    <input
                        type="checkbox"
                        checked={this.props.passed}
                        onChange={() => { this.props.handlePassedClick(this.props.code) }}>
                    </input>
                    <span className="checkmark"></span>
                </label>
                <label className="failedContainer">
                    <input
                        type="checkbox"
                        checked={this.props.failed}
                        onChange={() => { this.props.handleFailedClick(this.props.code) }}>
                    </input>
                    <span className="checkmark"></span>
                </label>
            </li>
        );
    }
}