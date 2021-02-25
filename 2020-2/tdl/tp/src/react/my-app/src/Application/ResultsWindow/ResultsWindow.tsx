import React from 'react'
import './ResultsWindow.css'
import { CreditsWindow } from './CreditsWindow/CreditsWindow'
import { AvailableWindow } from './AvailableWindow/AvailableWindow';
import { PassedWindow } from './PassedWindow/PassedWindow'
import { RemainingWindow } from './RemainingWindow/RemainingWindow'
import { HelpWindow } from "./HelpWindow/HelpWindow"
import { UpdateWindow } from "./UpdateWindow/UpdateWindow"

interface ResultsWindowProps {
    renderId: string,
    studentId: string,
    carreerId: number,
    handleUpdateClick: any
}

export class ResultsWindow extends React.Component<ResultsWindowProps> {

    nextUniqueRenderId: number;

    constructor(props: any) {
        super(props);
        this.nextUniqueRenderId = 1;
    }

    render(): JSX.Element {

        this.nextUniqueRenderId++;

        switch (this.props.renderId) {
            case ('available'):
                return (
                    <div className="resultsWindowBox">
                        <AvailableWindow key={"availableWindow" + this.nextUniqueRenderId.toString()} studentId={this.props.studentId} carreerId={this.props.carreerId} />
                    </div>
                );
            case ('credits'):
                return (
                    <div className="emptyResultsWindowBox">
                        <CreditsWindow key={"creditsWindow" + this.nextUniqueRenderId.toString()} studentId={this.props.studentId} carreerId={this.props.carreerId} />
                    </div>
                );
            case ('passed'):
                return (
                    <div className="resultsWindowBox">
                        <PassedWindow key={"passedWindow" + this.nextUniqueRenderId.toString()} studentId={this.props.studentId} carreerId={this.props.carreerId} />
                    </div>
                );
            case ('remaining'):
                return (
                    <div className="resultsWindowBox">
                        <RemainingWindow key={"remainingWindow" + this.nextUniqueRenderId.toString()} studentId={this.props.studentId} carreerId={this.props.carreerId} />
                    </div>
                );
            case ('update'):
                return (
                    <div className="resultsWindowBox">
                        <UpdateWindow key={"updateWindow" + this.nextUniqueRenderId.toString()} studentId={this.props.studentId} carreerId={this.props.carreerId} handleUpdateClick={this.props.handleUpdateClick} />
                    </div>
                );
            default:
                return (
                    <div className="resultsWindowBox">
                        <HelpWindow key={"helpWindow" + this.nextUniqueRenderId.toString()} />
                    </div>
                );
        }
    }
}