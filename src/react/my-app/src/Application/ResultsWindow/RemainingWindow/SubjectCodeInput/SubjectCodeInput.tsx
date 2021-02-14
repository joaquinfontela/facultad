import React, { ChangeEvent } from 'react'
import "./SubjectCodeInput.css"

interface SubjectCodeInputProps {
    input: string
    handleChange: any
}

export class SubjectCodeInput extends React.Component<SubjectCodeInputProps, {}> {

    constructor(props: any) {
        super(props);
    }

    render() {
        return (
            <input className="subjectCodeInput" value={this.props.input} onChange={(e) => { this.props.handleChange(e.target.value) }}></input>
        );
    }
}