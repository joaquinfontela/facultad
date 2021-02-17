import React from 'react'
import "./CreditsWindow.css"
import ApiHandler from '../../API/ApiHandler'

interface CreditsWindowState {
    data: any
}

interface CreditsWindowProps {
    studentId: string
}

export class CreditsWindow extends React.Component<CreditsWindowProps, CreditsWindowState> {

    constructor(props: any) {
        super(props);
        this.state = {
            data: {}
        }
    }

    componentDidMount() {
        new ApiHandler().getStudentData(this.props.studentId).then((d) => {
            console.log(d);
            this.setState({
                data: d
            });
        });
    }

    render() {
        if (!this.state.data.data) {
            return (<div className="creditsWindow"></div>);
        }

        return (
            <div className="creditsWindow">
                A lo largo de tu carrera acumulaste {this.state.data.data.credits} créditos.
            </div>
        );
    }
}