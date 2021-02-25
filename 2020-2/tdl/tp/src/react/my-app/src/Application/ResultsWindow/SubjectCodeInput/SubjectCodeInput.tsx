import React, { ChangeEvent } from 'react'
import "./SubjectCodeInput.css"

interface SubjectCodeInputProps {
    input: string
    handleChange: Function
}

export class SubjectCodeInput extends React.Component<SubjectCodeInputProps, {}> {

    constructor(props: any) {
        super(props);
    }

    render(): JSX.Element {
        return (
            <input className="subjectCodeInput" placeholder="XX.XX" value={this.props.input} onChange={(e) => { this.props.handleChange(e.target.value) }}></input>
        );
    }
}