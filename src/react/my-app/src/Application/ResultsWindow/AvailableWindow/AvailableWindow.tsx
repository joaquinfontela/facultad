import React from 'react'
import "./AvailableWindow.css"
import { SubjectRender } from '../SubjectRender/SubjectRender'
import ApiHandler from '../../API/ApiHandler'

interface Subject {
    code: string,
    name: string,
    credits: number
}

interface AvailableWindowState {
    data: any
}

interface AvailableWindowProps {
    studentId: string
}

export class AvailableWindow extends React.Component<AvailableWindowProps, AvailableWindowState> {

    constructor(props: any) {
        super(props);
        this.state = {
            data: {}
        }
    }

    componentDidMount(): void {
        new ApiHandler().getStudentData(this.props.studentId).then((d) => {
            this.setState({
                data: d
            });
        });
    }

    render(): JSX.Element {
        if (!this.state.data.data) {
            return (<div className="availableWindow">
                <ul>{ }</ul>
            </div>);
        }
        const available: Subject[] = this.state.data.data.available;

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
                    key={s.code}
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
