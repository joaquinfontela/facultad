import React from 'react'
import "./CreditsWindow.css"
import ApiHandler from '../../API/ApiHandler'

interface CreditsWindowState {
    data: any
}

interface CreditsWindowProps {
    studentId: string
    carreerId: number
}

export class CreditsWindow extends React.Component<CreditsWindowProps, CreditsWindowState> {

    constructor(props: any) {
        super(props);
        this.state = {
            data: {}
        }
    }

    componentDidMount(): void {
        new ApiHandler().getStudentData(this.props.studentId).then((d: any) => {
            this.setState({
                data: JSON.parse(d)
            });
        });
    }

    render(): JSX.Element {
        if (!this.state.data.data || this.props.carreerId === 12) {
            return (<div className="creditsWindow"></div>);
        }

        return (
            <div className="creditsWindow">
                A lo largo de tu carrera acumulaste {this.state.data.data[this.props.carreerId].credits} créditos.
            </div>
        );
    }
}