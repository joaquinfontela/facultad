import React from 'react'
import "./SubjectRender.css"

interface SubjectRenderProps {
    code: string,
    name: string,
    credits: number
}

export class SubjectRender extends React.Component<SubjectRenderProps, {}> {

    constructor(props: any) {
        super(props);
    }

    render(): JSX.Element {
        return (
            <li className="subjectData">
                <ul>
                    <li className="subjectCodeName">{this.props.code + " - " + this.props.name}</li>
                    <li className="subjectCredits">{"Otorga " + this.props.credits + " creditos"}</li>
                </ul>
            </li>
        );
    }
}